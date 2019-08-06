from assets.helper import print_stat
import random


def binary_search(list, item):
    low = 0
    high = len(list) - 1
    steps = 0

    while low <= high:
        mid = (low + high) // 2
        guess = list[mid]
        steps += 1
        if guess == item:
            print_stat(len(list), steps)
            return mid
        if guess > item:
            high = mid - 1
        else:
            low = mid + 1
    print_stat(len(list), steps)
    return None


if __name__ == "__main__":
    my_list = [1, 3, 5, 7, 9, 11, 16, 17, 19, 22, 25, 27, 29, 33]
    target = random.randint(1, 33)
    result = binary_search(my_list, target)
    print("{0} is on {1}".format(target, result))
