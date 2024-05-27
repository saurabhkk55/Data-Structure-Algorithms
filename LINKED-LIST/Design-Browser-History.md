# [1472](https://leetcode.com/problems/design-browser-history/description/). `Design Browser History`

```java
class Node{
    String data;
    Node prev = null;
    Node next = null;

    Node(String data) {
        this.data = data;
    }
}

class BrowserHistory {
    Node currNode;

    public BrowserHistory(String homepage) {
        Node newNode = new Node(homepage);
        currNode = newNode;
    }
    
    public void visit(String url) {
        Node newNode = new Node(url);
        newNode.prev = currNode;
        currNode.next = newNode;
        currNode = newNode;
    }
    
    public String back(int steps) {
        while(steps > 0) {
            if(currNode.prev == null) return currNode.data;
            currNode = currNode.prev;
            steps--;
        }
        return currNode.data;
    }
    
    public String forward(int steps) {
        while(steps != 0) {
            if(currNode.next == null) return currNode.data;
            currNode = currNode.next;
            steps--;
        }
        return currNode.data;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
```
