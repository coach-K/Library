package com.andela.library.queue;


import com.andela.library.model.Item;
import com.andela.library.model.Member;

import java.util.*;

public abstract class ItemQueue<B extends Item, M extends Member> {

    Map<B, PriorityQueue<M>> itemQueueMap;

    public ItemQueue() {
        itemQueueMap = new HashMap<>();
    }

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

    public PriorityQueue<M> getItemQueue(B item) {
        if (itemQueueMap.containsKey(item))
            return itemQueueMap.get(item);
        else return null;
    }

    public ArrayList<PriorityQueue<M>> getAllItemQueue(Collection<? extends B> items) {
        ArrayList<PriorityQueue<M>> itemList = new ArrayList<>();
        for (B item : items) {
            itemList.add(getItemQueue(item));
        }
        return itemList;
    }

    public void removeItemQueue(B item) {
        itemQueueMap.remove(item);
    }

    public void removeAllItemsQueue(Collection<? extends B> items) {
        for (B item : items) {
            removeItemQueue(item);
        }
    }

    public Iterator<M> iterator(B item) {
        return getItemQueue(item).iterator();
    }

    public int itemQueueSize() {
        return itemQueueMap.size();
    }

    public boolean itemQueueContains(B item) {
        return itemQueueMap.containsKey(item);
    }

    public Object[] itemQueueToArray(B item) {
        return itemQueueMap.get(item).toArray();
    }

    public void clearItemQueue() {
        itemQueueMap.clear();
    }

}
