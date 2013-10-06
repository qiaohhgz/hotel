package hotel.common.db;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.PropertyNotFoundException;
import org.hibernate.property.ChainedPropertyAccessor;
import org.hibernate.property.PropertyAccessor;
import org.hibernate.property.PropertyAccessorFactory;
import org.hibernate.property.Setter;
import org.hibernate.transform.ResultTransformer;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* Result transformer that allows to transform a result to
* a user specified class which will be populated via setter
* methods or fields matching the alias names.
* <p/>
* <pre>
* List resultWithAliasedBean = s.createCriteria(Enrolment.class)
* 			.createAlias("student", "st")
* 			.createAlias("course", "co")
* 			.setProjection( Projections.projectionList()
* 					.add( Projections.property("co.description"), "courseDescription" )
* 			)
* 			.setResultTransformer( new AliasToBeanResultTransformer(StudentDTO.class) )
* 			.list();
* <p/>
*  StudentDTO dto = (StudentDTO)resultWithAliasedBean.get(0);
* 	</pre>
*
* @author max
*/
public class AliasToBeanResultTransformerHelper implements ResultTransformer, Serializable {

    // IMPL NOTE : due to the delayed population of setters (setters cached
    // 		for performance), we really cannot properly define equality for
    // 		this transformer
    private static final Logger log = Logger.getLogger(AliasToBeanResultTransformerHelper.class);
    private final Class resultClass;
    private boolean isInitialized;
    private String[] aliases;
    private Setter[] setters;
    //extend
    private Map<String, String> changeMapping = new HashMap<String, String>();
    private boolean isNotSetAll;

    public AliasToBeanResultTransformerHelper(Class resultClass) {
        if (resultClass == null) {
            throw new IllegalArgumentException("resultClass cannot be null");
        }
        isInitialized = false;
        this.changeMapping = new HashMap<String, String>();
        this.resultClass = resultClass;
    }

    public Object transformTuple(Object[] tuple, String[] aliases) {
        Object result;

        try {
            if (!isInitialized) {
                initialize(aliases);
            } else {
                check(aliases);
            }

            result = resultClass.newInstance();

            for (int i = 0; i < aliases.length; i++) {
                if (setters[i] != null) {
                    setters[i].set(result, tuple[i], null);
                }
            }
        } catch (InstantiationException e) {
            throw new HibernateException("Could not instantiate resultclass: " + resultClass.getName());
        } catch (IllegalAccessException e) {
            throw new HibernateException("Could not instantiate resultclass: " + resultClass.getName());
        }

        return result;
    }

    private void initialize(String[] aliases) {
        PropertyAccessor propertyAccessor = new ChainedPropertyAccessor(
                new PropertyAccessor[]{
                        PropertyAccessorFactory.getPropertyAccessor(resultClass, null),
                        PropertyAccessorFactory.getPropertyAccessor("field")
                }
        );
        this.aliases = new String[aliases.length];
        this.setters = new Setter[aliases.length];
        for (int i = 0; i < aliases.length; i++) {
            String alias = aliases[i];
            if (alias != null) {
                String beanAttrName = alias;
                this.aliases[i] = alias;
                boolean isContainsKey = this.changeMapping.containsKey(alias);
                boolean isNotContainsKey = !isContainsKey;
                if (isNotSetAll && isNotContainsKey) {
                    continue;
                }
                if (isContainsKey) {
                    beanAttrName = this.changeMapping.get(alias);
                }
                try {
                    setters[i] = propertyAccessor.getSetter(resultClass, beanAttrName);
                } catch (PropertyNotFoundException e) {
                    log.info("Alias not found = " + alias);
                    continue;
                }
            }
        }
        isInitialized = true;
    }

    private void check(String[] aliases) {
        if (!Arrays.equals(aliases, this.aliases)) {
            throw new IllegalStateException(
                    "aliases are different from what is cached; aliases=" + Arrays.asList(aliases) +
                            " cached=" + Arrays.asList(this.aliases));
        }
    }

    public List transformList(List collection) {
        return collection;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AliasToBeanResultTransformerHelper that = (AliasToBeanResultTransformerHelper) o;

        if (!resultClass.equals(that.resultClass)) {
            return false;
        }
        if (!Arrays.equals(aliases, that.aliases)) {
            return false;
        }

        return true;
    }

    public int hashCode() {
        int result = resultClass.hashCode();
        result = 31 * result + (aliases != null ? Arrays.hashCode(aliases) : 0);
        return result;
    }

    public AliasToBeanResultTransformerHelper addMapping(String dbAttrName, String beanAttrName) {
        this.changeMapping.put(dbAttrName, beanAttrName);
        return this;
    }

    public AliasToBeanResultTransformerHelper isNotSetAll(boolean isNotSetAll) {
        this.isNotSetAll = isNotSetAll;
        return this;
    }
}