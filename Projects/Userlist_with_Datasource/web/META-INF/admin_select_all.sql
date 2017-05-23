/* 
 */

select 
    java_test.users.user_name,
    java_test.users.user_pass,
    java_test.user_roles.role_name
from java_test.users 
    join java_test.user_roles 
        on java_test.users.user_name = java_test.user_roles.user_name;