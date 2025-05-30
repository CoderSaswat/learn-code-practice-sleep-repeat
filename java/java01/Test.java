//package java01;
//
//import java.util.*;
//import java.util.concurrent.Executors;
//
//public class Test {
//    public static void main(String[] args) {
//        String[] names = {"sumit ahuja", "john", "Anand singh"};
//        //sort names array by last name usng java 8 features
//        // o/p= {"john", "Sumit Ahuja", "Anand singh"};
//
//        List<String> list = Arrays.stream(names).sorted(Comparator.comparing(Test::getPriority)).toList();
//        System.out.println(list);
//    }
//
//    private static String getPriority(String s) {
//        String[] split = s.split(" ");
//        if (split.length == 2) {
//            return split[1];
//        }
//        return "";
//    }
//
//
//}
//
//
//
//
////t1=Executors.getFixedThread(1);
////t.submit(()->{
////    //task
////})
//
////userService
//
////EmailService emailService
//
//UserService(EmailService @Qalifier("awsEmail") emailService){
//    this.emailService = emailServicel;
//}
//
////interface EmailService
//
//@Primary()
//AWSSEs implements EmailService
//
//SndGrid implements EmailService
//
//
//@RestControllerAdvice
//class GlobalControllerHandler {
//
//    @ExceptionHandler(MethodAgrumentNotValidException.class)
//    handleMethodArgNotValidExp( ){
//     //
//    }
//
//    @ExceptionHandler(MethodAgrumentNotValidException.class)
//    handleMethodArgNotValidExp( ){
//        //
//    }
//
//    @ExceptionHandler(MethodAgrumentNotValidException.class)
//    handleMethodArgNotValidExp( ){
//        //
//    }
//
//}
//
//
//
//class ProdectSeriveClint{
//
//    RestTemplate restTemplate;
//
//    ProductDto getProductByid(id){
//        url
//
//        <ProductDto> =   restTemplate.getForObject(url);
//    }
//}
//
//department - employee
//
//select e.emp_name, d.dept_name from employee e
//join department d on e.dept_id = d.dept_id
//
//
//    submitForm =()->{
//
//}
//     Form()=>{
//            <>
////                <form>
//               <p>Username</p>
//                <input placeholder = "enter the username"/>
//
//                <p> Password</p>
//                <input placeholder = "enter the password"/>
//
//                <Button onClick= {()->submitForm}>Submit<Button/>
//            <form/>
//            </>
//
//        }
//
//
//
//
