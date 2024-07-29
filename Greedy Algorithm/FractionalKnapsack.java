import java.util.*;
/*
 * Problem Statement: The weight of N items and their corresponding values are given. 
 * We have to put these items in a knapsack of weight W such that the total value obtained is maximized.

Note: We can either take the item as a whole or break it into smaller units.

Example:

Input: N = 3, W = 50, values[] = {100,60,120}, weight[] = {20,10,30}.

Output: 240.00

Explanation: The first and second items  are taken as a whole  while only 20 units of the third item is taken. 
Total value = 100 + 60 + 80 = 240.00
 */

class Item {
    int value;
    int weight;

    Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Item [ Value : " + this.value + " - Weight : " + this.weight + " ]";
    }
}

class ItemComparator implements Comparator<Item> {

    @Override
    public int compare(Item o1, Item o2) {
        double wperval1 = (double) o1.value / (double) o1.weight;
        double wperval2 = (double) o2.value / (double) o2.weight;
        
        if(wperval1 < wperval2) return 1;
        else if(wperval1 > wperval2) return -1;
        else return 0;
    }
    
}

public class FractionalKnapsack {

    public static void getMaxProfit(Item [] items, int n, int capacity) {
        Arrays.sort(items, new ItemComparator());

        int totalWeight = 0, totalValue = 0, curWeight = 0;
        for(int i = 0; i < n; i++) {
            curWeight = totalWeight + items[i].weight;
            if(curWeight <= capacity) {
                totalWeight += items[i].weight;
                totalValue += items[i].value;
            }
            else {
                double balance = capacity - totalWeight;
                totalValue += ((double) items[i].value / (double) items[i].weight) * balance;
                break;
            }
        }

        System.out.println("Total value is " + totalValue);
    }

    public static void main(String[] args) {
        int n = 3, weight = 50;
        Item arr[] = {new Item (100,20),new Item(60,10),new Item(120,30)};
        getMaxProfit(arr, n, weight);
    }
}
