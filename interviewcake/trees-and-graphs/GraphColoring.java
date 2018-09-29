public class GraphColoring {

    // O(N*D + M) where D is the D is degree and M is number of neighbours
    public colorGraph(GraphNode[] graph, String[] colors) {
        for (GraphNode node : graph) {
            Set<String> neighborsColors = node.getNeighbors().stream()
                    .filter(n -> n.hasColor())
                    .map(n -> n.getColor())
                    .collect(Collectors.toSet());
            List<String> availableColors = Arrays.stream(colors)
                    .filter(c -> !neighborsColors.contains(c))
                    .collect(Collectors.toList());
            if (availableColors.size() != 0) {
                node.setColor(availableColors.get(0));
            } else {
                throw new RuntimeException();
            }
        }
    }

    // When assigning color, break the loop as soon as we find one for more efficiency O(N + M)
    // O(D) space to store the neighborsColors
    public colorGraphOptimised(GraphNode[] graph, String[] colors) {
        for (GraphNode node : graph) {

            // if there is a loop
            /*node.getNeighbors().stream()
                    .filter(n -> n.label.equals(node.label))
                    .findAny()
                    .ifPresent(a -> {
                        throw new IllegalArgumentException();
                    });*/
            if (node.getNeighbors().contains(node)) {
                throw new IllegalArgumentException();
            }

            Set<String> neighborsColors = node.getNeighbors().stream()
                    .filter(n -> n.hasColor())
                    .map(n -> n.getColor())
                    .collect(Collectors.toSet());
            for (String c : colors) {
                if (!neighborsColors.contains(c)) {
                    node.setColor(c);
                    break;
                }
            }
            // Not necessary as we know it is always mathematically possible to color the graph with D + 1 colours
            if (!node.hasColor()) {
                throw new RuntimeException();
            }
        }
    }
}

public class GraphNode {

    private String label;
    private Set<GraphNode> neighbors;
    private Optional<String> color;

    public GraphNode(String label) {
        this.label = label;
        neighbors = new HashSet<GraphNode>();
        color = Optional.empty();
    }

    public String getLabel() {
        return label;
    }

    public Set<GraphNode> getNeighbors() {
        return Collections.unmodifiableSet(neighbors);
    }

    public void addNeighbor(GraphNode neighbor) {
        neighbors.add(neighbor);
    }

    public boolean hasColor() {
        return color.isPresent();
    }

    public String getColor() {
        return color.get();
    }

    public void setColor(String color) {
        this.color = Optional.ofNullable(color);
    }
}