1 	网页解析出错
	application.properties file: spring.thymeleaf.mode=LEGACYHTML5

	maven add:
	<dependency>
		<groupId>net.sourceforge.nekohtml</groupId>
		<artifactId>nekohtml</artifactId>
	</dependency>
	
2 	Jquery load html: 
	not apply css
	because of missing html tag: <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
	
	some jquery need change: ex  $('.collapse-link').on('click', function() { ..  => $(document).on('click', '.collapse-link',  function() {...