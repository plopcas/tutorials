public class MeshMessage {
    // BFS always finds the shortes path, although uses more space than DFS
    public String[] findShortesRouteWithTooMuchMemory(Map<String, String[]> graph, String startNode, String endNode) {
        if (!graph.containsKey(startNode) || !graph.containsKey(endNode)) {
            throw new IllegalArgumentException();
        }
        Map<String, String> routes = new HashMap<>();
        routes.put(startNode,null);
        Set<String> seen = new HashSet<>();
        seen.add(startNode);
        Deque<String> queue = new ArrayDeque<>();
        queue.add(startNode);
        while (!queue.isEmpty()) {
            String currentNode = queue.remove();
            if (currentNode.equals(endNode)) {
                List<String> path = new ArrayList<>();
                String node = currentNode;
                while (node != null) {
                    path.add(node);
                    node = routes.get(node);
                }
                Collections.reverse(path);
                return path.toArray(new String[path.size()]);
            }
            String[] neighbors = graph.get(currentNode);
            for (String n : neighbors) {
                if (!seen.contains(n)) {
                    seen.add(n);
                    queue.add(n);
                    routes.put(n, currentNode);
                }
            }
        }
        return null;
    }

    public String[] findShortesRoute(Map<String, String[]> graph, String startNode, String endNode) {

        if (!graph.containsKey(startNode) || !graph.containsKey(endNode)) {
            throw new IllegalArgumentException();
        }

        Map<String, String> routes = new HashMap<>();
        routes.put(startNode,null);

        Deque<String> queue = new ArrayDeque<>();
        queue.add(startNode);

        while (!queue.isEmpty()) {

            String currentNode = queue.remove();
            if (currentNode.equals(endNode)) {
                List<String> path = new ArrayList<>();
                String node = currentNode;
                while (node != null) {
                    path.add(node);
                    node = routes.get(node);
                }
                Collections.reverse(path);
                return path.toArray(new String[path.size()]);
            }

            String[] neighbors = graph.get(currentNode);
            for (String n : neighbors) {
                if (!routes.containsKey(n)) {
                    queue.add(n);
                    routes.put(n, currentNode);
                }
            }

        }

        return null;
    }

}