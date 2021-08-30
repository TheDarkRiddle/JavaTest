
public class Java_Class
{
    public static class GetContentCanNotReturnNull
            extends RuntimeException {
        public GetContentCanNotReturnNull(String errorMessage) {
            super(errorMessage);
        }
    }
    public static class GetContentXIsBiggerThanTheList
            extends RuntimeException {
        public GetContentXIsBiggerThanTheList(String errorMessage) {
            super(errorMessage);
        }
    }

    public static void main(String[] args) {

        MyLinkedList<Integer> Liste = new MyLinkedList<>();

        Liste.addFirst(1);
        Liste.addFirst(2);
        Liste.addFirst(3);
        Liste.addFirst(4);
        Liste.addFirst(5);
        Liste.addFirst(6);


        for (int i = 0;i < Liste.getSize();i++){
            System.out.println(Liste.getContantAtX(i));
        }

    }
}

      class MyLinkedList<T>{

     private class DataNode{
         T inhalt;
        DataNode next;

         public DataNode(T inhalt, DataNode next) {
             this.inhalt = inhalt;
             this.next = next;
         }
     }

    private DataNode first =  null;

    public void addFirst(T inhalt){
        System.out.println("Added");
        first = new DataNode(inhalt, first);

    }

    public int getSize(){
        int size = 0;
        DataNode run = first;
       while(run != null)
       {    size ++;
            run = run.next;
       }
       return size;
    }

    public T getContantAtX(int x){
        if (x > this.getSize())
            throw new Java_Class.GetContentXIsBiggerThanTheList("ERROR: GetContentXIsBiggerThanTheList");
        int index = 0;
         DataNode run = first;
        while(index != x){
            index++;
            run = run.next;
        }
        if (run != null)
        return run.inhalt;
        else throw new Java_Class.GetContentCanNotReturnNull("ERROR:GetContentCanNotReturnNull");
    }
}