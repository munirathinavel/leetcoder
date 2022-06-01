class Solution {
    
    
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> route = new ArrayList<>();
        Map<String, PriorityQueue<String>> targets = new HashMap<>();
        for(List<String> ticket: tickets) {
            targets.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).add(ticket.get(1));
        }
        visit("JFK", route, targets);
        return route;
    }
    
        private void visit(String airport, List<String> route, Map<String, PriorityQueue<String>> targets) {
            while(targets.containsKey(airport) && !targets.get(airport).isEmpty()) {
                visit(targets.get(airport).poll() ,route, targets);
            }
            route.add(0, airport);
        }
    }

// class Solution {
//     public List<String> findItinerary(List<List<String>> tickets) {

// 		Map<String, PriorityQueue<String>> map = new HashMap<>();

// 		for (List<String> ticket : tickets) {
// 			String from = ticket.get(0);
// 			String to = ticket.get(1);
// 			if (map.containsKey(from)) {
// 				map.get(from).offer(to);
// 			}else {
// 				PriorityQueue<String> minHeap = new PriorityQueue<>();
// 				minHeap.offer(to);
// 				map.put(from, minHeap);
// 			}
// 		}

// 		List<String> res = new ArrayList<>();
// 		dfs(map, res, "JFK");
// 		return res;
// 	}

// 	public void dfs(Map<String, PriorityQueue<String>> map, List<String> res, String from) {
// 		PriorityQueue<String> arrivals = map.get(from);
// 		while (arrivals != null && !arrivals.isEmpty()) {
// 			String to = arrivals.poll();
// 			dfs(map, res, to);
// 		}
// 		res.add(0, from);
// 	}
    
// }
