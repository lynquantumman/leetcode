import heapq
class Solution(object):

    def trapRainWater(self, heightMap):
        """
        :type heightMap: List[List[int]]
        :rtype: int
        """
        # 1.add surrounding blocks to the heap
        # 2.poll the lowest one and add new ones to the heap
        # 每次将新的元素添加进堆以后，将列表中的值改为False
        # 3.at the same time add the differences to the sum
        # 4.return the sum
        if len(heightMap) == 0:
            return 0
        sum = 0
        heap = []
        # 第一行
        i = 0
        while i < len(heightMap[0]):
            heapq.heappush(heap,(heightMap[0][i],0, i))
            heightMap[0][i] = -1
            i+=1


        # 最后一行
        i = 0
        while i < len(heightMap[len(heightMap) - 1]):
            heapq.heappush(heap,(heightMap[len(heightMap) - 1][i],len(heightMap) - 1, i))
            heightMap[len(heightMap) - 1][i] = -1
            i+=1


        # 第一列
        i = 1
        while i < len(heightMap) - 1:
            heapq.heappush(heap,(heightMap[i][0],i, 0))
            heightMap[i][0] = -1
            i+=1

        # 最后一列
        i = 1
        while i < len(heightMap) - 1:
            heapq.heappush(heap,(heightMap[i][len(heightMap[0]) - 1],i, len(heightMap[0]) - 1))
            heightMap[i][len(heightMap[0]) - 1] = -1
            i+=1
    # 需要有一列来记录

        print((heightMap[2][5]==-1))
        while len(heap)!=0:
            ele = heapq.heappop(heap)


            # print(heightMap[ele[1]][ele[2]+1])
            # print((heightMap[ele[1]][ele[2] + 1] != -1))
            if (ele[2] + 1) < len(heightMap[0]) and heightMap[ele[1]][ele[2] + 1] != -1:
                if heightMap[ele[1]][ele[2] + 1] > ele[0]:
                    heapq.heappush(heap,(heightMap[ele[1]][ele[2] + 1],ele[1], ele[2] + 1))
                else:
                    sum += (ele[0] - heightMap[ele[1]][ele[2] + 1])
                    heapq.heappush(heap,(ele[0],ele[1], ele[2] + 1))
                heightMap[ele[1]][ele[2]+1] = -1


            if (ele[1]-1)>0 and (heightMap[ele[1] - 1][ele[2]] != -1):
                if heightMap[ele[1] - 1][ele[2]] > ele[0]:
                    heapq.heappush(heap,(heightMap[ele[1] - 1][ele[2]],(ele[1]-1),ele[2]))
                else:
                    sum += (ele[0] - heightMap[ele[1] - 1][ele[2]])
                    heapq.heappush(heap,(ele[0], ele[1] - 1, ele[2]))
                heightMap[ele[1]-1][ele[2]] = -1


            if (ele[2] - 1)>= 0 and heightMap[ele[1]][ele[2]-1] != -1:
                print("line 90")
                if heightMap[ele[1]][ele[2] - 1] > ele[0]:
                    heapq.heappush(heap,(heightMap[ele[1]][ele[2] - 1],ele[1], ele[2] - 1))
                else:
                    sum += (ele[0] - heightMap[ele[1]][ele[2] - 1])
                    heapq.heappush(heap,(ele[0],ele[1], ele[2] - 1))
                heightMap[ele[1]][ele[2]-1] = -1
            # if ele[1]+1==1 and ele[2]==2:
            #     print(heightMap)
            if ele[1] + 1 < len(heightMap) and heightMap[ele[1] + 1][ele[2]] != -1:

                if heightMap[ele[1] + 1][ele[2]] > ele[0]:
                    heapq.heappush(heap,(heightMap[ele[1] + 1][ele[2]], ele[1] + 1, ele[2]))
                else:
                    sum += (ele[0] - heightMap[ele[1] + 1][ele[2]])
                    heapq.heappush(heap,(ele[0], ele[1] + 1, ele[2]))
                heightMap[ele[1] +1][ele[2]] = -1

        return sum


        