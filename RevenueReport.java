package com.ecommerce.analytics;

public class RevenueReport {

    private double totalRevenue;
    private long itemCount;
    private double maxRevenue;

    public RevenueReport() {
    }

    public void addRevenue(double revenue) {
        totalRevenue += revenue;
        itemCount++;
        maxRevenue = Math.max(maxRevenue, revenue);
    }

    public void combine(RevenueReport other) {
        totalRevenue += other.totalRevenue;
        itemCount += other.itemCount;
        maxRevenue = Math.max(maxRevenue, other.maxRevenue);
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }

    public long getItemCount() {
        return itemCount;
    }

    public double getMaxRevenue() {
        return maxRevenue;
    }

    @Override
    public String toString() {
        return "RevenueReport{" +
                "totalRevenue=" + totalRevenue +
                ", itemCount=" + itemCount +
                ", maxRevenue=" + maxRevenue +
                '}';
    }
}