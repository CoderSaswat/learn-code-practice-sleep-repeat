//package java02;
//
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.Setter;
//import lombok.ToString;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import static java02.Test06.restaurantList;
//
//interface OrderStrategy{
//    void placeOrder(OrderInputDto orderInputDto);
//}
//
//
//class OrderStrategyFactory{
//    static OrderStrategy getOrderStrategy(String strategy){
//        if(strategy.equals("Lowest Bill Cost")){
//            return new LowestBillCost();
//        } else if (strategy.equals("Highest Rating")) {
//            return new HighestRating();
//        }
//        return null;
//    }
//}
//
//
//
//class LowestBillCost implements OrderStrategy{
//
//    @Override
//    public void placeOrder(OrderInputDto orderInputDto) {
//        System.out.println("order placed by LowestBillCost");
//        List<String> items = orderInputDto.getItems().stream().map(ItemsInputDto::getItem).toList();
//        List<Restaurant> list = restaurantList.stream().filter(restaurant -> ifItemsPresentInRestaurant(restaurant, items)).toList();
//    }
//
//    boolean ifItemsPresentInRestaurant(Restaurant restaurant, List<String> items){
//        for (String item : items){
//            List<String> list = restaurant.getMenuList().stream().map(menu -> menu.getItem()).toList();
//            if(!list.contains(item)){
//                return false;
//            }
//        }
//        return true;
//    }
//}
//
//
//class HighestRating implements OrderStrategy{
//
//    @Override
//    public void placeOrder(OrderInputDto orderInputDto) {
//        System.out.println("order placed by HighestRating");
//    }
//}
//
//
//
//
//
//
//@Getter
//@Setter
//@AllArgsConstructor
//@ToString
//class Restaurant {
//    private Integer id;
//    private String name;
//    private List<Menu> menuList;
//}
//
//@Getter
//@Setter
//@AllArgsConstructor
//@ToString
//class Menu{
//    private String item;
//    private Integer price;
//}
//
//@Getter
//@Setter
//@AllArgsConstructor
//@ToString
//class OrderInputDto{
//    private Integer userId;
//    private List<ItemsInputDto> items;
//    private String strategy;
//}
//
//@Getter
//@Setter
//@AllArgsConstructor
//@ToString
//class ItemsInputDto{
//    private String item;
//    private Integer quantities;
//}
//
//@Getter
//@Setter
//@AllArgsConstructor
//@ToString
//class Order{
//    private Integer id;
//    private Integer userId;
//    private Integer totalPrice;
//    private String status;
//}
//
//class OrderItem{
//    private Integer id;
//    private Integer orderId;
//    private String item;
//    private Integer quantities;
//}
//
//class RestaurantService{
//    public void onboardRestaurant(Restaurant restaurant) {
//        restaurantList.add(restaurant);
//        System.out.println(restaurantList);
//    }
//
//    public void updateRestaurantMenu(Integer restaurantId, Menu newMenuItem) {
//        Optional<Restaurant> restaurantOp = restaurantList.stream().filter(restaurant1 -> restaurant1.getId() == restaurantId).findFirst();
//        if(restaurantOp.isPresent()){
//            Restaurant restaurant = restaurantOp.get();
//            List<Menu> menuList = restaurant.getMenuList();
//            menuList.add(newMenuItem);
//            restaurant.setMenuList(menuList);
//            System.out.println(restaurantList);
//        }
//
//    }
//
//}
//class OrderService{
//    public void placeOrder(OrderInputDto orderInputDto) {
//        OrderStrategy orderStrategy = OrderStrategyFactory.getOrderStrategy(orderInputDto.getStrategy());
//        orderStrategy.placeOrder(orderInputDto);
//    }
//}
//
//
//public class Test06 {
//        static List<Restaurant> restaurantList= new ArrayList<>();
//        static List<Order> orderList= new ArrayList<>();
//    public static void main(String[] args) {
//
//        //1
//        List<Menu> menuList = List.of(new Menu("Item1", 100));
//        Restaurant restaurant = new Restaurant(1,"Udupi",menuList);
//
//        //2
//        Integer restaurantId = 1;
//        Menu newMenuItem = new Menu("Item2", 200);
//
//        //2
//        OrderInputDto orderInputDto = new OrderInputDto(11, List.of(new ItemsInputDto("Dosa", 2)),"Lowest Cost");
//
//        RestaurantService restaurantService = new RestaurantService();
//        OrderService orderService = new OrderService();
//
//        System.out.println("choose and option");
//        Integer input = 1;
//
//        switch (input){
//            case 1:
//                restaurantService.onboardRestaurant(restaurant);
//            case 2:
////                restaurantService.updateRestaurantMenu(restaurantId,newMenuItem);
//            case 3:
////                orderService.placeOrder(orderInputDto);
//        }
//    }
//
//}
