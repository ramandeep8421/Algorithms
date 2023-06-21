def first_at_least(arr, value):
    lo = 0
    hi = len(arr)
    while lo < hi:
        mid = (lo + hi) // 2
        if arr[mid] >= value:
            hi = mid
        else:
            lo = mid + 1
    return lo

n, m = map(int, input().split())
cities = []
towers = []

for _ in range(n):
    city = int(input())
    cities.append(city)

for _ in range(m):
    tower = int(input())
    towers.append(tower)

minR = 0
for i in range(n):
    tower_right = first_at_least(towers, cities[i])
    tower_left = tower_right - 1

    minR_for_this_city = float('inf')
    if tower_right < m:
        assert towers[tower_right] >= cities[i]
        minR_for_this_city = min(minR_for_this_city, towers[tower_right] - cities[i])
    if tower_left >= 0:
        assert towers[tower_left] <= cities[i]
        minR_for_this_city = min(minR_for_this_city, cities[i] - towers[tower_left])

    minR = max(minR, minR_for_this_city)

print(minR)
