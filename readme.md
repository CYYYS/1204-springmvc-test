####注意事项
1.在web项目时,application类需要继承一个类:extends WebMvcConfigurerAdapter.
2.在使用thymeleaf时,它时必须使用双标签的,不能使用单标签.
3.在接受多参数时,可以在参数表里面用实体或者使用Map接受,注意
在使用map接受时,一定不能省略@RequestParam注解,这样表明它是一个接受参数的map.
4.在使用header时,可以接受header中的信息,使用注解@RequestHeader.
5.使用重定向时,redirectAttribute.addAttribute方法是会在地址栏显示出来,转发到其他的controller时需要再用model.addAttribute为其设置属性,而且在另一个controller层可以直接使用key值获取到key所对应的value值.redirectAttribute.addFlashAttribute方法使用在重定向到页面时,可以直接获取到值,但是刷新以后就没有了,在重定向到其他的controller时,不需要接收值.直接在最后的页面获取到值就好.
6.在使用转发时,使用model.addAttribute时,如果转发到其他的controller,不能直接用key获取value,必须使用原生态的HttpServletRequest.getAttribute()获取到.再做其他的处理.
