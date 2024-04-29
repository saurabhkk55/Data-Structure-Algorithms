class Solution {
    static float  gasStation (int[] arr, int n, int k) {
        int[] stationCounts = new int[n-1];

        for (int i=1; i<=k; i++) {
            float  maxSpace = -1, maxSpaceIdx = -1;
            for (int j=0; j<=n-2; j++) {
                float diff = arr[j+1] - arr[j];
                float space = diff/(stationCounts[j]+1);
                if (space > maxSpace) {
                    maxSpace = space;
                    maxSpaceIdx = j;
                }
            }
            stationCounts[((int) maxSpaceIdx)]++;
        }

        float maxSpace = -1;
        for (int i=0; i<=n-2; i++) {
            float diff = arr[i+1] - arr[i];
            float space = diff/(stationCounts[i]+1);
            if (space > maxSpace) {
                maxSpace = space;
            }
        }
        return maxSpace;
    }
}
public class Brute {
    public static void main(String[] args) {
        int[] arr = {1, 13, 17, 23};
        int stations = 5;
        float ans = Solution.gasStation(arr, arr.length, stations);
        System.out.printf("Ans: %f", ans);
    }
}
// Time Complexity: O(k*n) + O(n), n = size of the given array, k = no. of gas stations to be placed.
// Reason: O(k*n) to insert k gas stations between the existing stations with maximum distance. Another O(n) for finding the answer i.e. the maximum distance.
// Space Complexity: O(n-1) as we are using an array to keep track of placed gas stations.

// Naive Approach: 
// We are given n gas stations. Between them, there are n-1 sections where we may insert the new stations to reduce the distance. So, we will create an array of size n-1 and each of its indexes will represent the respective sections between the given gas stations. 

// In each iteration, we will identify the index 'i' where the distance (arr[i+1] - arr[i]) is the maximum. Then, we will insert new stations into that section to reduce that maximum distance. The number of stations inserted in each section will be tracked using the previously declared array of size n-1.

// Finally, after placing all the stations we will find the maximum distance between two consecutive stations. To calculate the distance using the previously discussed formula, we will just do as follows for each section:
// distance = section_length / (number_of_stations_ inserted+1)

// Among all the values of ‘distance’, the maximum one will be our answer.

// Algorithm:
// 1. First, we will declare an array ‘howMany[]’ of size n-1, to keep track of the number of placed gas stations.
// 2. Next, using a loop we will pick k gas stations one at a time.
// 3. Then, using another loop, we will find the index 'i' where the distance (arr[i+1] - arr[i]) is the maximum and insert the current gas station between arr[i] and arr[i+1] (i.e. howMany[i]++).
// 4. Finally, after placing all the new stations, we will find the distance between two consecutive gas stations. For a particular section,
// distance = section_length / (number_of_stations_ inserted+1)
//     = (arr[i+1]-arr[i]) / (howMany[i]+1)
// 5. Among all the distances, the maximum one will be the answer.
