package codingTest.LeetCode;

import java.util.*;

public class no399 {

    public double[] calcEquation(
            List<List<String>> equations,
            double[] values,
            List<List<String>> queries
    ) {
        Map<String, Integer> map = new HashMap<>();
        int count = 0;

        // 변수마다 정수 인덱스 부여
        for (List<String> equation : equations) {
            String numerator = equation.get(0);
            String denominator = equation.get(1);

            if (!map.containsKey(numerator)) {
                map.put(numerator, count++);
            }

            if (!map.containsKey(denominator)) {
                map.put(denominator, count++);
            }
        }

        // 인접 행렬 생성
        double[][] graph = new double[map.size()][map.size()];

        for (double[] row : graph) {
            Arrays.fill(row, -1.0);
        }

        // 자기 자신과의 비율
        for (int i = 0; i < graph.length; i++) {
            graph[i][i] = 1.0;
        }

        // 간선 저장
        for (int i = 0; i < equations.size(); i++) {
            int from = map.get(equations.get(i).get(0));
            int to = map.get(equations.get(i).get(1));

            graph[from][to] = values[i];
            graph[to][from] = 1.0 / values[i];
        }

        double[] output = new double[queries.size()];
        Arrays.fill(output, -1.0);

        for (int i = 0; i < queries.size(); i++) {
            String startVariable = queries.get(i).get(0);
            String endVariable = queries.get(i).get(1);

            // 정의되지 않은 변수
            if (!map.containsKey(startVariable)
                    || !map.containsKey(endVariable)) {
                continue;
            }

            int start = map.get(startVariable);
            int end = map.get(endVariable);

            boolean[] visited = new boolean[map.size()];
            Queue<State> queue = new ArrayDeque<>();

            queue.offer(new State(start, 1.0));
            visited[start] = true;

            while (!queue.isEmpty()) {
                State current = queue.poll();

                if (current.node == end) {
                    output[i] = current.value;
                    break;
                }

                for (int next = 0; next < graph.length; next++) {
                    if (graph[current.node][next] == -1.0) {
                        continue;
                    }

                    if (visited[next]) {
                        continue;
                    }

                    visited[next] = true;

                    queue.offer(new State(
                            next,
                            current.value * graph[current.node][next]
                    ));
                }
            }
        }

        return output;
    }

    static class State {
        int node;
        double value;

        State(int node, double value) {
            this.node = node;
            this.value = value;
        }
    }
}