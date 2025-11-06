package in_class;

//제네릭 스택 선언
class GStack<T>{
    int tos;
    Object [] stck; //스택에 요소 저장 공간

    public GStack(){
        tos = 0;
        stck = new Object[10];
    }

    public void push(T item){
        if(tos == 10) //스택이 꽉차서 더이상 요소 삽입 불가능
            return;
        stck[tos] = item;
        tos++;
    }

    public T pop(){
        if(tos == 0) //스택이 비어 있어 꺼낼 요소가 없음
            return null;
        tos--;
        return(T)stck[tos]; //타입 매개변수 타입으로 캐스팅
    }

}

public class MyStack {
    public static void main(String[] args){
        GStack<String> stringStack = new GStack<String>();

        stringStack.push("seoul");
        stringStack.push("busan");
        stringStack.push("LA");

        for(int n=0; n<3; n++)
            System.out.println(stringStack.pop());

            GStack<Integer> intStack = new GStack<Integer>();

            intStack.push(1);
            intStack.push(3);
            intStack.push(5);

        for(int n=0; n<3; n++){
            System.out.println(intStack.pop());
        }
    }
}
