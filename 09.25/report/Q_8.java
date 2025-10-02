package report.Chapter_4;

/* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

 Account 클래스는 1개의 은행 계좌를 나타낸다.
 실행 결과와 같이 출력되도록 Account 클래스를 작성하라.
 잔금이 인출하는 금액보다 작으면, 잔금만큼만 인출된다.

 - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - */

class Account{
    private int balance; //계좌 잔액

    public Account(int balance){
        this.balance = balance;
    }

    //잔액조회
    public int getBalance(){
        return balance;
    }

    //단일 금액 입금
    public void deposit(int amout){
        if(amout > 0)
            balance += amout;
    }

    //여려 금액 입금
    public void deposit(int[] amounts){
        for (int amt : amounts) {
            if (amt > 0) {
                balance += amt;
            }
        }
    }

    public int withdraw(int amount) {
        if (amount <= 0) {
            return 0;
        }

        int withdrawAmount;
        if (balance >= amount) {
            balance -= amount;
            withdrawAmount = amount;
        } else {
            withdrawAmount = balance;
            balance = 0;
        }
        return withdrawAmount;
    }
}


/* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - */
public class Q_8 {
    public static void main(String[] args){
        Account a = new Account(100);
        a.deposit(5000);
        System.out.println("잔금은 " + a.getBalance() + "원입니다.");

        int bulk[] = {100, 500, 200, 700};
        a.deposit(bulk); //bulk[] 배열에 있는 모든 돈 예금
        System.out.print("잠금은 " + a.getBalance() + "원입니다");

        int money = 1000;
        int wMoney = a.withdraw(money);
        if(wMoney < money)
            System.out.println(wMoney + "원만 인출");
        else
            System.out.println(wMoney + "원 인출");

        System.out.println("잔금은 " + a.getBalance() + "원입니다");

    }
}
