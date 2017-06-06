from queue import PriorityQueue

class Solution(object):
	class Cell(object):
		"""docstring for Cell"""
		def __init__(self, row, col, height):
			super(Cell, self).__init__()
			self.row = row
			self.col = col
			self.height = height
			
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
        heap = PriorityQueue()
        # 第一行
        i = 0
		while i <len(heightMap[0]):
        	heap.put(Cell(0,i,heightMap[0][i]))
        	heightMap[0][i] = False
        	i++
        # 最后一行
        i = 0
        while i < len(heightMap[len(heightMap)-1]):
        	heap.put(Cell(len(heightMap)-1,i,heightMap[len(heightMap)-1][i]))
        	heightMap[len(heightMap)-1][i] = False
        	i++
        # 第一列
        i = 1
        while i < len(heightMap)-1:
        	heap.put(Cell(i,0,heightMap[i][0]))
        	heightMap[i][0] = False
        	i++
        # 最后一列
        i = 1
        while i < len(heightMap)-1:
        	heap.put(Cell(i,len(heightMap)-1,heightMap[i][len(heightMap)-1]))
        	heightMap[i][len(heightMap)-1]
        	i++
        # 需要有一列来记录
        while !heap.empty():
        	ele = heap.get()
        	ele.

        