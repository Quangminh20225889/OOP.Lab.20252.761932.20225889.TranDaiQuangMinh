import java.util.Scanner;

public class DaysOfMonth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int month = -1, year = -1;

        // Nhập năm
        while (year < 0) {
            System.out.print("Enter year: ");
            String s = sc.nextLine().trim();
            try {
                year = Integer.parseInt(s);
                if (year < 0) { System.out.println("Invalid! Try again."); year = -1; }
            } catch (Exception e) {
                System.out.println("Invalid! Try again.");
            }
        }

        // Nhập tháng
        String[] full  = {"january","february","march","april","may","june",
                          "july","august","september","october","november","december"};
        String[] abbr3 = {"jan","feb","mar","apr","may","jun",
                          "jul","aug","sep","oct","nov","dec"};
        String[] abbrD = {"jan.","feb.","mar.","apr.","may","june",
                          "july","aug.","sept.","oct.","nov.","dec."};

        while (month < 1 || month > 12) {
            System.out.print("Enter month: ");
            String s = sc.nextLine().trim().toLowerCase();
            try {
                month = Integer.parseInt(s);
                if (month < 1 || month > 12) {
                    System.out.println("Invalid! Try again.");
                    month = -1;
                }
            } catch (Exception e) {
                month = -1;
                for (int i = 0; i < 12; i++) {
                    if (s.equals(full[i]) || s.equals(abbr3[i]) || s.equals(abbrD[i])) {
                        month = i + 1;
                        break;
                    }
                }
                if (month == -1) System.out.println("Invalid! Try again.");
            }
        }

        // Kiểm tra năm nhuận
        boolean leap = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        int[] days = {31, leap ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        System.out.println("Month " + month + "/" + year
                + (leap ? " (Leap year)" : " (Common year)")
                + " has " + days[month - 1] + " days.");
    }
}
