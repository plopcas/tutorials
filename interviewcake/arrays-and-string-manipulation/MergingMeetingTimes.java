import java.util.*;

public class MergingMeetingTimes {

    public static void main(String[] args) {
        MergingMeetingTimes mergingMeetingTimes = new MergingMeetingTimes();

        List<Meeting> meetings = Arrays.asList(
                new Meeting(0, 1),
                new Meeting(3, 5),
                new Meeting(4, 8),
                new Meeting(10, 12),
                new Meeting(9, 10));

        List<Meeting> mergedMeetings = mergingMeetingTimes.merge(meetings);
    }

    public List<Meeting> merge(List<Meeting> meetings) {

        // make a copy to not destroy the input
        List<Meeting> sortedMeetings = new ArrayList<>();
        for (Meeting meeting : meetings) {
            sortedMeetings.add(new Meeting(meeting.getStartTime(), meeting.getEndTime()));
        }

        // sort first so that meetings that can be merged are adjacent
        Collections.sort(sortedMeetings, new Comparator<Meeting>() {
            @Override
            public int compare(Meeting m1, Meeting m2) {
                return m1.getStartTime() - m2.getStartTime();
            }
        });

        // merge the meetings
        List<Meeting> mergedMeetings = new ArrayList<>();
        mergedMeetings.add(sortedMeetings.get(0));
        for (Meeting meeting : sortedMeetings) {

            Meeting lastMergedMeeting = mergedMeetings.get(mergedMeetings.size() - 1);

            if (meeting.getStartTime() <= lastMergedMeeting.getEndTime()) {
                lastMergedMeeting.setEndTime(Math.max(meeting.getEndTime(), lastMergedMeeting.getEndTime()));
            }
            else {
                mergedMeetings.add(meeting);
            }
        }

        return mergedMeetings;
    }
}

public class Meeting {

    private int startTime;
    private int endTime;

    public Meeting(int startTime, int endTime) {
        // number of 30 min blocks past 9:00 am
        this.startTime = startTime;
        this.endTime   = endTime;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }
}