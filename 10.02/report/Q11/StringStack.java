package report.Q11;


interface IStack {
    int capacity(); // 스택에 저장 가능한 개수 리턴
    int length(); // 스택에 현재 저장된 개수 리턴
    boolean push(String val); // 스택의 톱(top)에 문자열 저장하고 true 리턴.
    // 꽉 차서 넣을 수 없으면 false 리턴
    String pop(); // 스택의 톱(top)에 저장된 문자열 리턴. 스택이 비어 있으면 null 리턴
}
public class StringStack implements IStack{
    private int top=0;
    private String[] data = null;

    public StringStack(int capacity) {
        data = new String[capacity];
    }

    @Override
    public int capacity() {
        return data.length;
    }

    @Override
    public int length() {
        return top;
    }

    @Override
    public boolean push(String val) {
        if(top==data.length) return false;
        data[top]=val;
        top++;
        return true;
    }

    @Override
    public String pop() {
        if(top==0) return null;
        top--;
        return data[top];
    }
}

