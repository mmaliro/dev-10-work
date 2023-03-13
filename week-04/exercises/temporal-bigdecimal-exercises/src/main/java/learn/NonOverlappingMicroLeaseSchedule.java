package learn;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * A schedule of MicroLeases where no lease can overlap another.
 */
public class NonOverlappingMicroLeaseSchedule {

    // on success, a MicroLease is stored in leases
    private ArrayList<MicroLease> leases = new ArrayList<>();

    // 1. Complete the add method.

    /**
     * Attempts to add a MicroLease to the Schedule.
     * Rules:
     * - if lease is null, return false
     * - if lease.getStart or lease.getEnd is null, return false
     * - if lease.getStart is later then lease.getEnd, return false
     * - if the lease overlaps any other lease in leases, return false
     * - otherwise, add to leases and return true
     *
     * @param lease - a MicroLease to be added to the schedule.
     * @return true if MicroLease is valid (see rules)
     * false if not valid
     */
    public boolean add(MicroLease lease) {

        if (lease == null ) {
            return false;
        }
        if (lease.getStart() == null || lease.getEnd() == null) {
            return false;
        }
        if (lease.getStart().isAfter(lease.getEnd())) {
            return false;
        }

        LocalDateTime startLease = lease.getStart();
        LocalDateTime endLease = lease.getEnd();

        for (MicroLease ml : leases) {
            LocalDateTime startExisting = ml.getStart();
            LocalDateTime endExisting = ml.getEnd();

            if (startLease.isEqual(startExisting)) {
                return false;
            }

            if (startLease.isBefore(startExisting) && endLease.isAfter(startExisting)) {
                return false;
            }

            if (startLease.isAfter(startExisting) && startLease.isBefore(endExisting)) {
                return false;
            }
        }

        leases.add(lease);
        return true;
    }
}