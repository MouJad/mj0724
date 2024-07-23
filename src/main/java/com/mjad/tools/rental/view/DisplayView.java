package com.mjad.tools.rental.view;

import com.mjad.tools.rental.controller.DisplayController;
import com.mjad.tools.rental.model.RentalCharge;
import com.mjad.tools.rental.model.Tool;
import java.util.List;
import java.util.Scanner;

/**
 * @author MJad
 **/
public class DisplayView {
  private DisplayController displayController;

  public DisplayView() {}
  public DisplayView(DisplayController displayController) {
    this.displayController = displayController;
  }
  public void initiateDisplay(List<Tool> tools, List<RentalCharge> rentalCharges) {
    System.out.println("\n################ TOOLS RENTAL REGISTER ##############");
    displayTools(tools);
    displayRentalCharges(rentalCharges);
    getCustomerInput();
    System.out.println("\n\n\n\n\n\n");
  }
  private void displayTools(List<Tool> tools) {
    String cellPadding = "| %-13s | %-13s | %-15s |%n";
    System.out.format("+---------------+---------------+-----------------+%n");
    System.out.format("| Tool Code     | Tool Type     | Brand           |%n");
    System.out.format("+---------------+---------------+-----------------+%n");
    for(Tool tool : tools){
      System.out.format(cellPadding, tool.getCode(), tool.getType(), tool.getBrand());
    }
    System.out.format("+---------------+---------------+-----------------+%n");
  }
  private void displayRentalCharges(List<RentalCharge> rentalCharges) {
    String cellPadding = "| %-13s | %-13s | %-15s | %-15s | %-15s |%n";
    System.out.format("+---------------+---------------+-----------------+-----------------+-----------------+%n");
    System.out.format("| Tool Type     | Daily Charge  | Weekday Charge  | Weekend Charge  | Holiday Charge  |%n");
    System.out.format("+---------------+---------------+-----------------+-----------------+-----------------+%n");
    for(RentalCharge charge : rentalCharges){
      System.out.format(cellPadding, charge.getType(), "$"+charge.getDailyChargeAmt(), charge.isWeekdayCharge() ? "Yes":"No", charge.isWeekendCharge() ? "Yes":"No", charge.isHolidayCharge() ? "Yes":"No");
    }
    System.out.format("+---------------+---------------+-----------------+-----------------+-----------------+%n");
  }
  public void getCustomerInput() {
    String toolCode, checkout, checkoutDate = "";
    int rentalDayCount, discountPercent = 0;

    do{
      try{
        // Take inputs from customers for the tool to rent
        Scanner sc = new Scanner (System.in);
        System.out.print("\nTool Code: ");
        toolCode = sc.nextLine();
        System.out.print("Rental day count: ");
        rentalDayCount = sc.nextInt();
        System.out.print("Discount %: ");
        discountPercent = sc.nextInt();
        System.out.print("Checkout Date mm/dd/yy: ");
        checkoutDate = sc.next();
        System.out.print("Ready to proceed (Y/N): ");
        checkout = sc.next();
        if (checkout.equalsIgnoreCase("Y") || checkout.equalsIgnoreCase("Yes")) {
          displayController.checkout(toolCode.trim().toUpperCase(), rentalDayCount, discountPercent, checkoutDate.trim());
        } else {
          handleExit(sc, checkout);
        }
      } catch(Exception ex ){ throw ex; }

    } while(checkout.equalsIgnoreCase("N") || checkout.equalsIgnoreCase("No"));
  }

  private void handleExit(Scanner sc, String checkout) {
    String exit = "";
    System.out.print("Exit (Yes/No): ");
    exit = sc.next();
    if (exit.equalsIgnoreCase("y") || exit.equalsIgnoreCase("yes")) {
      System.exit(0);
    }
  }
}
