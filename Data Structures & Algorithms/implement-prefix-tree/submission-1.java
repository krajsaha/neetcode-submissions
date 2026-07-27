class tnode{

    boolean isWord;
    tnode[] tnodes;

    tnode(){
        this.isWord=false;
        this.tnodes = new tnode[26];
    }
}
class PrefixTree {
    tnode head; 
    public PrefixTree() {
         this.head =  new tnode();
    }

    public void insert(String word) {
        tnode current = head;
        for(char c : word.toCharArray()){
                if(current.tnodes[c-'a']==null){
                    current.tnodes[c-'a'] = new tnode();
                }

                current=current.tnodes[c-'a'];
        }
        current.isWord=true;
    }

    public boolean search(String word) {
         tnode current = head;
        for(char c : word.toCharArray()){
                if(current.tnodes[c-'a']==null){
                    return false;
                }

                current=current.tnodes[c-'a'];
        }
        return current.isWord;
    }

    public boolean startsWith(String prefix) {
         tnode current = head;
        for(char c : prefix.toCharArray()){
                if(current.tnodes[c-'a']==null){
                    return false;
                }

                current=current.tnodes[c-'a'];
        }
        return true;
    }
}
