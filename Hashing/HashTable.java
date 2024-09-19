public class HashTable <T> {
    Entry [] Arr_Hash;
    int size;
    public HashTable (int size){
        this.size = size;
        Arr_Hash = new Entry[this.size];
        for(int i=0;i<size;i++){
            Arr_Hash[i]=new Entry <T>();
        } 
    }
    
    int GetHash (int key){
        return key%size;
    }
    
    public void put (int key ,T value){
        int index = GetHash(key);
        Entry Arr_Value = Arr_Hash[index];
        Entry temp = new Entry<T>(key, value);
        temp.next = Arr_Value.next;
        Arr_Value.next = temp;
    }
    
    public T Get (int key){
        int index = GetHash(key);
        Entry Arr_Value = Arr_Hash[index];
        while (Arr_Value !=null){
            if(Arr_Value.getKey() == key){
                return (T) Arr_Value.value;
            }
            Arr_Value = Arr_Value.next; 
        }
        
         return null;
    }
    
    public boolean Contain_Key (int key){
        int i = GetHash(key);
        Entry curr = Arr_Hash[i];
        if(curr.getKey() == key){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String str="";
        for(int i=0;i<Arr_Hash.length;i++){
            int index=GetHash(i);
            Entry temp = Arr_Hash[index];
            while (temp!=null){
                str+=temp.value+" ";
                temp=temp.next;
            }
            str+='\n';
        }
        return str;
    }
}
