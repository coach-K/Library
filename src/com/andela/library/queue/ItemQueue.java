package com.andela.library.queue;


import com.andela.library.model.Item;
import com.andela.library.model.Member;

import java.util.*;

/**
 * An abstract generic ItemQueue class.
 * Holds a list (HashMap) of Item class with corresponding PriorityQueue of Member class.
 * @param <B> Item B as Key.
 * @param <M> PriorityQueue of M as Value.
 */
public abstract class ItemQueue<B extends Item, M extends Member> {

    Map<B, PriorityQueue<M>> itemQueueMap;

    /**
     * Create new instance of ItemQueue.
     */
    public ItemQueue() {
        itemQueueMap = new HashMap<>();
    }

    /**
     * Add or update an item and its corresponding PriorityQueue of member.
     * @param item the key item
     * @param member member to be added to the corresponding PriorityQueue.
     */
    public void addItemQueue(B item, M member) {
        PriorityQueue<M> memberList;
        if (itemQueueMap.containsKey(item)) {
            memberList = itemQueueMap.get(item);
            if (!memberList.contains(member))
                memberList.add(member);
            itemQueueMap.replace(item, memberList);
        } else {
            memberList = new PriorityQueue<>();
            memberList.add(member);
            itemQueueMap.put(item, memberList);
        }
    }

    /**
     * Gets the corresponding PriorityQueue of item
     * @param item item to get its Queue.
     * @return PriorityQueue of Members or null
     */
    public PriorityQueue<M> getItemQueue(B item) {
        if (itemQueueMap.containsKey(item))
            return itemQueueMap.get(item);
        else return null;
    }

    /**
     * Gets the corresponding PriorityQueue of item in the collection
     * @param items collection of items
     * @return ArrayList of Queues or null
     */
    public ArrayList<PriorityQueue<M>> getAllItemQueue(Collection<? extends B> items) {
        ArrayList<PriorityQueue<M>> itemList = new ArrayList<>();
        for (B item : items) {
            itemList.add(getItemQueue(item));
        }
        return itemList;
    }

    /**
     * Remove the corresponding PriorityQueue of the item
     * @param item item object to be removed
     */
    public void removeItemQueue(B item) {
        itemQueueMap.remove(item);
    }

    /**
     * Removes all corresponding PriorityQueue in the item collection.
     * @param items collection object to be removed.
     */
    public void removeAllItemsQueue(Collection<? extends B> items) {
        for (B item : items) {
            removeItemQueue(item);
        }
    }

    /**
     * Returns an iterator of members for the specified item.
     * @param item item to return its members.
     * @return Iterator of Member.
     */
    public Iterator<M> iterator(B item) {
        return getItemQueue(item).iterator();
    }

    /**
     * Returns the size of items.
     * @return int
     */
    public int itemQueueSize() {
        return itemQueueMap.size();
    }

    /**
     * Checks if ItemQueue contains item.
     * @param item item to check.
     * @return boolean
     */
    public boolean itemQueueContains(B item) {
        return itemQueueMap.containsKey(item);
    }

    /**
     * converts PriorityQueue corresponding of the specified item into an Array.
     * @param item item to get its queue.
     * @return Object[]
     */
    public Object[] itemQueueToArray(B item) {
        return itemQueueMap.get(item).toArray();
    }

    /**
     * Clears ItemQueue.
     */
    public void clearItemQueue() {
        itemQueueMap.clear();
    }

}
