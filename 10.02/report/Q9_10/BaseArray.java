package report.Q9_10;

class BaseArray{

    //배열 메모리
    protected int array [];

    //다음 삽입할 배열에 대한 인덱스
    protected int nextIndex = 0;

    //생성자
    public BaseArray(int size){
        array = new int [size];
    }

    public int length(){
        return array.length;
    }

    //중수 n을 배열 끝에 추가
    public void add(int n){
        //배열이 꽉 찼으면 추가 안 함
        if(nextIndex == array.length) return;
            array[nextIndex] = n;
            nextIndex++;
    }

    public void print(){
        for(int n : array) System.out.print(n + " ");
        System.out.println();
    }
}