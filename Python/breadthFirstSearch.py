from collections import deque
from assets.helper import print_stat

graph = {}
graph["you"] = ["alice", "bob", "claire"]
graph["bob"] = ["anuj", "peggy"]
graph["alice"] = ["peggy"]
graph["claire"] = ["thom", "jonny"]
graph["anuj"] = []
graph["peggy"] = []
graph["thom"] = []
graph["jonny"] = []


def person_is_seller(name):
    return name[-1] == 'm'


def breadth_first_search(name):
    steps = 0
    search_queue = deque()
    search_queue += graph[name]
    searched = []
    while search_queue:
        steps += 1
        person = search_queue.popleft()
        if not person in searched:
            if person_is_seller(person):
                # print(person + " is a mango seller!")
                print_stat(len(graph), steps)
                return person
            else:
                search_queue += graph[person]
                searched.append(person)
    print_stat(len(graph), steps)
    return None


if __name__ == "__main__":
    result = breadth_first_search("you") or "nobody"
    print(result + " is a mango seller!")
