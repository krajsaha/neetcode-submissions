class Node{
    char c;
    Node[] children;
    boolean isWord;
    Node(char c){
        this.c=c;
        this.children=new Node[26];
    }

    @Override
    public String toString() {
        return "Node{" +
                "c=" + c +
                ", children=" + Arrays.toString(children) +
                ", isWord=" + isWord +
                '}';
    }
}
class WordDictionary {
    Node head;
    public WordDictionary() {
        this.head=new Node('*');
    }

    public void addWord(String word) {
        Node curr=head;
        for(char c : word.toCharArray()){
            if(curr.children[c-'a']==null){
                curr.children[c-'a']=new Node(c);
            }
            curr=curr.children[c-'a'];
        }
        curr.isWord=true;
    }

    boolean isPresent(String word,int idx,Node curr){
        // if(idx[0]>=word.length()){
        //     return false;
        // }
        if(curr==null){
            return false;
        }
        if(idx==word.length()){
            return curr.isWord;
        }

        char c = word.charAt(idx);
        idx++;
        boolean flag=false;
        if(c=='.'){
            for(Node child : curr.children){
                flag= flag || isPresent(word,idx,child);
            }
        }else{
             flag=flag || isPresent(word,idx,curr.children[c-'a']);
        }
        return flag;
    }

    public boolean search(String word) {
        
        return isPresent(word,0,head);
    }
}