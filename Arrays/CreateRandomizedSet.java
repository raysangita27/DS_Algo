class RandomizedSet {

    /** Initialize your data structure here. */
    HashSet<Integer> set;
    public RandomizedSet() {
        set = new HashSet<Integer>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(!set.contains( val))
        {
             set.add(val);
            return true;
        }
        return false; 
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(set.contains(val))
        {
            set.remove(val);
            return true;
        }
        return false;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int size = set.size();
        if(size == 0)
            return -1;
        ArrayList<Integer> itemList = new ArrayList<>(set);
        int item = new Random().nextInt(size);
        return itemList.get(item);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
