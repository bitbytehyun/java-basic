package core.stream.application;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamEx {
    public List<String> convertNameFrom(List<User> users) {
        return users.stream()
                .filter(User::isActive)
                .map(user -> user.getName().toUpperCase())
                .collect(Collectors.toList());

    }

    public List<Log> flatLogs(List<List<Log>> logGroups) {
        return logGroups.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    public Map<String, Long> countByAgeGroup(List<User> users) {
        return users.stream()
                .collect(Collectors.groupingBy(User::getAgeGroup, Collectors.counting()));
    }

    public List<User> sortByCreatedAt(List<User> users) {
        return users.stream()
                .sorted(Comparator.comparing(User::getCreatedAt))
                .collect(Collectors.toList());
    }

    public Boolean hasMinor(List<User> users) {
        return users.stream()
                .anyMatch(user -> user.getAge() < 19);
    }

    public long getSales(List<User> users) {
        return users.stream()
                .filter(User::isActive)
                .mapToLong(User::getSalesAmount)
                .sum();
    }

    class User {
        public String name;
        public int age;
        public String ageGroup;
        public LocalDateTime createdAt;
        public long salesAmount;

        public boolean isActive() {
            return true;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public String getAgeGroup() {
            return ageGroup;

        }

        public LocalDateTime getCreatedAt() {
            return createdAt;
        }

        public long getSalesAmount() {
            return salesAmount;
        }
    }

    class Log {
    }
}
