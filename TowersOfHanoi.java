import java.util.Scanner;

/**
 * The TowersOfHanoi program uses a recursive function to
 * calculate the optimal move set to solve the towersOfHanoi
 * for any number of rings, however it gets really slow past 15ish
 * code effieciency is defined by O(n^2 - 1) so it just about doubles
 * per number greater you input
 *
 * @author Liam Csiffary
 * @version 1.0
 * @since 2022-04-12
 */

public class TowersOfHanoi {
  static int counter = 0;

  // basically copied from the video, but I can explain it
  public static void hanoiSolver(int n, int start, int end) {
    counter++;
    // base case. When there is only one disk on the rod
    if (n == 1) {
      System.out.println(start + "->" + end);

    } else {
      // get the other rod, not the start, not the end.
      int other = 6 - (start + end);

      // n-1 because you're removing one of the disks from the rod
      // and passes it start and other, start where the disk was and move it
      // to the other available rod. Does this over and over until base case
      // I believe.
      hanoiSolver(n - 1, start, other);

      // then runs this one until base case is reached
      System.out.println(start + "->" + end);
      hanoiSolver(n - 1, other, end);
    }
  }

  // main function
  public static void main(String[] args) {
    // create vars and objects
    Scanner sc = new Scanner(System.in);
    int userNum = 1;

    // get the users input
    while (true) {
      System.out.print("How many disks would you like in your tower 1->");
      String userIn = sc.nextLine();

      // make sure its a whole number greater than or equal to 1
      try {
        userNum = Integer.parseInt(userIn);

        if (userNum >= 1) {
          break;
        } else {
          System.out.println("Please input a whole number >= 1");
        }

      } catch (NumberFormatException e) {
        System.out.println("Please input a whole number >= 1");
      }
    }

    // call the hanoi solver program
    hanoiSolver(userNum, 1, 3);
    System.out.println("The program ran " + counter + " times");
    sc.close();
  }
}
