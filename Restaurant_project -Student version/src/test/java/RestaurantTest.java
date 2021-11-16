package test.java;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalTime;
import java.util.List;

import org.junit.jupiter.api.Test;

import main.java.Restaurant;
import main.java.itemNotFoundException;

class RestaurantTest {
    Restaurant restaurant;
    //REFACTOR ALL THE REPEATED LINES OF CODE
    LocalTime openingTime = LocalTime.parse("10:30:00");
    LocalTime closingTime = LocalTime.parse("22:00:00");

    //>>>>>>>>>>>>>>>>>>>>>>>>>OPEN/CLOSED<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    //-------FOR THE 2 TESTS BELOW, YOU MAY USE THE CONCEPT OF MOCKING, IF YOU RUN INTO ANY TROUBLE
    @Test
    public void is_restaurant_open_should_return_true_if_time_is_between_opening_and_closing_time(){
        //WRITE UNIT TEST CASE HERE
    	 restaurant = new Restaurant("Dominos", "Kolkata", LocalTime.parse("10:30:00"), LocalTime.parse("22:00:00"));
    	 LocalTime currentTime = LocalTime.parse("12:30:00");
    	 boolean val1 = currentTime.compareTo(restaurant.openingTime) > 0;
    	 boolean val2 = currentTime.compareTo(restaurant.closingTime) < 0;
    	 
    	 assertEquals(true, val1);
    	 
    	 assertEquals(false, val2);
    }

    @Test
    public void is_restaurant_open_should_return_false_if_time_is_outside_opening_and_closing_time(){
    	 restaurant = new Restaurant("Dominos", "Kolkata", LocalTime.parse("10:30:00"), LocalTime.parse("22:00:00"));
    	 LocalTime currentTime = LocalTime.parse("06:00:00");
    	 boolean val1 = currentTime.compareTo(restaurant.openingTime) > 0;
    	 boolean val2 = currentTime.compareTo(restaurant.closingTime) < 0;
    	 
    	 assertEquals(false, val1);
    	 
    	 assertEquals(true, val2);

    }

    //<<<<<<<<<<<<<<<<<<<<<<<<<OPEN/CLOSED>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>


    //>>>>>>>>>>>>>>>>>>>>>>>>>>>MENU<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    @Test
    public void adding_item_to_menu_should_increase_menu_size_by_1(){
        
        restaurant =new Restaurant("Amelie's cafe","Chennai",openingTime,closingTime);
        restaurant.addToMenu("Sweet corn soup",119);
        restaurant.addToMenu("Vegetable lasagne", 269);

        int initialMenuSize = restaurant.getMenu().size();
        restaurant.addToMenu("Sizzling brownie",319);
        assertEquals(initialMenuSize+1,restaurant.getMenu().size());
    }
    @Test
    public void removing_item_from_menu_should_decrease_menu_size_by_1() throws itemNotFoundException {
        restaurant =new Restaurant("Amelie's cafe","Chennai",openingTime,closingTime);
        restaurant.addToMenu("Sweet corn soup",119);
        restaurant.addToMenu("Vegetable lasagne", 269);

        int initialMenuSize = restaurant.getMenu().size();
        restaurant.removeFromMenu("Vegetable lasagne");
        assertEquals(initialMenuSize-1,restaurant.getMenu().size());
    }
    @Test
    public void removing_item_that_does_not_exist_should_throw_exception() {
        restaurant =new Restaurant("Amelie's cafe","Chennai",openingTime,closingTime);
        restaurant.addToMenu("Sweet corn soup",119);
        restaurant.addToMenu("Vegetable lasagne", 269);

        assertThrows(itemNotFoundException.class,
                ()->restaurant.removeFromMenu("French fries"));
    }
    //<<<<<<<<<<<<<<<<<<<<<<<MENU>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    
    
    
    //TDD approach, failing test case
    @Test
    public void when_items_selected_total_cost_should_be_returned() {
    	restaurant = null;
    	List<String> selectedItems = null;
    	int totalCost = restaurant.getTotalCost(selectedItems);
    }
    
}