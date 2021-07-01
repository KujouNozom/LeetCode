# 815. 公交路线 [BFS]
import collections
from typing import List


class Solution:
    def numBusesToDestination(self, routes: List[List[int]], source: int, target: int) -> int:
        if not routes:
            return -1
        if source == target:
            return 0

        length = len(routes)
        station_bus_dict = collections.defaultdict(set)
        edges_dict = collections.defaultdict(set)
        for bus_route, stations in enumerate(routes):
            for station in stations:
                buses = station_bus_dict[station]
                for bus in buses:
                    edges_dict[bus_route] = edges_dict[bus_route]
                    edges_dict[bus_route].add(bus)
                    edges_dict[bus] = edges_dict[bus]
                    edges_dict[bus].add(bus_route)
                buses.add(bus_route)
                station_bus_dict[station] = buses

        distances = [-1] * length
        for index in station_bus_dict.get(source):
            distances[index] = 1

        queue = collections.deque()
        queue.extend(station_bus_dict.get(source))
        while queue:
            bus_route = queue.popleft()
            edges = edges_dict[bus_route]
            for edge in edges:
                if distances[edge] == -1:
                    distances[edge] = distances[bus_route] + 1
                    queue.append(edge)

        target_buses = station_bus_dict[target]
        ans = 1000
        for target_bus in target_buses:
            if distances[target_bus] != -1:
                ans = min(ans, distances[target_bus])
        return -1 if ans == 1000 else ans
