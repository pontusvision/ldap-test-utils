package com.github.trevershick.test.ldap.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface LdapConfiguration {
	String DEFAULT_ROOT_OBJECT_DN = "dc=root";
	String DEFAULT_ROOT_ENTRY_OBJECTCLASS = "domain";
	int DEFAULT_PORT = 10389;
	String DEFAULT_PASSWORD = "password";
	String DEFAULT_BIND_DN = "cn=admin";

	boolean useRandomPortAsFallback() default false;

	int port() default DEFAULT_PORT;

	LdapEntry base() default @LdapEntry(objectclass = DEFAULT_ROOT_ENTRY_OBJECTCLASS, dn = DEFAULT_ROOT_OBJECT_DN);

	LdapEntry[] entries() default {};

	Ldif[] ldifs() default {};

	String bindDn() default DEFAULT_BIND_DN;

	String password() default DEFAULT_PASSWORD;

	boolean useSchema() default true;
}
