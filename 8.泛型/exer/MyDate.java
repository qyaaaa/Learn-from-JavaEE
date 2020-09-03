package javase高级.sep3.exer;

public class MyDate implements Comparable<MyDate>{
    private int year;
    private int month;
    private int day;

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public int compareTo(MyDate o) {
        int minusYear = this.getYear() - o.getYear();
        //比较年
        if (minusYear != 0){
            return minusYear;
        }
        int minusMonth = this.getMonth() - o.getMonth();
        //比较月
        if (minusMonth != 0){
            return minusMonth;
        }
        //比较日
        return this.getDay() - o.getDay();
    }
}
