   1. First JVM gets loaded  
   1. Main method gets executed
   1. ApplicationContext is loaded
   1. ApplicationContext reads xml configuration file
   1. ApplictionContext pre loads one object for the each bean in the config file 
	   if the bean is not mrked as lazy-init= "true"
   1. lazy-init="true" - This informs springContainer not to pre-load object for this bean
   1. By default spring early loads objects in memory.
   1. For lazy-init beans object is created only when the getBean() method is called.
   1. For pre-init beans getBean() return the reference of the pre loaded object.
   1. By default only one object for every bean is created(singleton).
   1. singleton : Atleast one object for every class but not more than one object
   1. Spring for lazy-init beans creates a singleton object on firstcall of getBeans() method
     and then uses that object for future getBean() method calls

---

## Prototype  
Prototype beans are by default lazy-init  
Prototype are not singleton  
A new object is created for prototype when getBean() method is called every time

```java
	  	<bean id="act" class="com.chainsys.projectA.beans.Actor" scope="prototype" ></bean>
```
---
##Bean with parameterized constructor


```java
<bean id="film" class="com.chainsys.projectA.beans.Movie" >
  		<constructor-arg type="java.lang.String" value="Vikram" />
  		 <constructor-arg type="java.lang.String" value="Lokesh" />
  	</bean>
```
---
##Factory method
```java
	<bean id="nvsilunch" class="com.chainsys.projectA.beans.Lunch"  factory-method="createNonVegSouthIndianLunch" 
  	  		factory-bean="lf"/>
  	  	<bean id="vsilunch" class="com.chainsys.projectA.beans.Lunch"  factory-method="createVegSouthIndianLunch" 
  	  		factory-bean="lf"/>
  	  	<bean id="nilunch" class="com.chainsys.projectA.beans.Lunch"  factory-method="createNorthIndianLunch" 
  	  		factory-bean="lf"/>
  	  	<bean id="chlunch" class="com.chainsys.projectA.beans.Lunch"  factory-method="createChineseLunch" 
  	  		factory-bean="lf"/>
```

================================================================================================

depends-on="mrf,fourstroke"(here mrf first instantiated and then fourstroke instantiated)  



   The depends-on attribute can explicitly force one or more beans to be initialized before the bean using this element is initialized. 
   To express a dependency on multiple beans, supply a list of bean names as the value of the depends-on attribute, with commas, whitespace and semicolons, used as valid delimiters.

=================================================================================================
LifeCycle Methods : 
	1. init-method is post object creation 
	2. destroy-method is pre object destruction.
    init-method="" - this method is executed immediately after the constructor.
    - This method can be used to setup the object before it is ready for service calls.
    - destroy-method is only working with singleton.
    - destroy-method is executed before garbage collector call.
    - When an object is start init-method runs then it will run destroy method when set to null.

==================================================================================================   
    
   Spring does not manage the complete lifecycle of a prototype bean: the container instantiates, configures, decorates and otherwise assembles a prototype object, hands it to the client and then has no further knowledge of that prototype instance. For releasing resources try to implement a custom bean post processor.
   
====================================================================================================  
   
Notes: 
	The Spring framework enables automatic dependency injection. 
	In other words, by declaring all the bean dependencies in a Spring configuration file, Spring 	 	  container can autowire relationships between collaborating beans. 
	This is called Spring bean autowiring.

Autowiring has the following advantages:
		• Autowiring can significantly reduce the need to specify properties or constructor arguments. (Other mechanisms such as a bean template discussed elsewhere in this chapter are also valuable in this regard.)
		• Autowiring can update a configuration as your objects evolve. For example, if you need to add a dependency to a class, that dependency can be satisfied automatically without you needing to modify the configuration.

   Thus autowiring can be especially useful during development, without negating the option of switching to explicit wiring when the code base becomes more stable
You can combine autowire behavior with dependency checking, which is performed after autowiring completes.
   