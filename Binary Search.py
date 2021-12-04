# Imtiaz Adar
# Binary Search

def binary_search(li, element):
    left = 0
    right = len(li) - 1
    while(left <= right):
        mid = left + (right - left) // 2
        if li[mid] == element:
            return mid
        elif li[mid] < element:
            left = mid + 1
        else:
            right = mid - 1
    return -1

li = [10, 20, 30, 40, 50, 60, 70]
element = int(input('Enter element which you want to search : '))
pos = binary_search(li, element)
print(f'Element in {pos} position')
