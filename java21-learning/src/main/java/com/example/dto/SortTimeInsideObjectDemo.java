package com.example.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortTimeInsideObjectDemo {

  // ----- Plain classes -----
  public static class PeriodEntry {
    private String period; // e.g. "2026-01-23T12:00:00.000Z"
    private List<WebsiteBlock> website_blocks;

    public PeriodEntry() {}

    public String getPeriod() { return period; }
    public void setPeriod(String period) { this.period = period; }

    public List<WebsiteBlock> getWebsite_blocks() { return website_blocks; }
    public void setWebsite_blocks(List<WebsiteBlock> website_blocks) { this.website_blocks = website_blocks; }

    @Override
    public String toString() {
      return "PeriodEntry{period='" + period + "', website_blocks=" + website_blocks + "}";
    }
  }

  public static class WebsiteBlock {
    private String domain;
    private int count;
    private List<String> categories;

    public WebsiteBlock() {}

    public String getDomain() { return domain; }
    public void setDomain(String domain) { this.domain = domain; }

    public int getCount() { return count; }
    public void setCount(int count) { this.count = count; }

    public List<String> getCategories() { return categories; }
    public void setCategories(List<String> categories) { this.categories = categories; }

    @Override
    public String toString() {
      return "WebsiteBlock{domain='" + domain + "', count=" + count + ", categories=" + categories + "}";
    }
  }

  // ----- Helpers -----
  public static WebsiteBlock mockWebsiteBlock(String domain, int count, String... categories) {
    WebsiteBlock wb = new WebsiteBlock();
    wb.setDomain(domain);
    wb.setCount(count);
    wb.setCategories(Arrays.asList(categories));
    return wb;
  }

  /** Sort by ISO timestamp string inside the object (ascending). Nulls go last. */
  public static void sortPeriodsAscNullLast(List<PeriodEntry> list) {
    Comparator<PeriodEntry> cmp =
        Comparator.comparing(
            (PeriodEntry p) -> p.getPeriod() == null ? null : Instant.parse(p.getPeriod()),
            Comparator.nullsLast(Comparator.naturalOrder())
        );
    list.sort(cmp);
  }

  /** Sort by ISO timestamp string inside the object (descending). Nulls go last. */
  public static void sortPeriodsDescNullLast(List<PeriodEntry> list) {
    Comparator<PeriodEntry> cmp =
        Comparator.comparing(
            (PeriodEntry p) -> p.getPeriod() == null ? null : Instant.parse(p.getPeriod()),
            Comparator.nullsLast(Comparator.naturalOrder())
        ).reversed();
    list.sort(cmp);
  }

  /** Convert the object's ISO timestamp to epochMillis string. */
  public static String toEpochMillisString(PeriodEntry p) {
    if (p.getPeriod() == null) return null;
    return String.valueOf(Instant.parse(p.getPeriod()).toEpochMilli());
  }

  // ----- Demo -----
  public static void main(String[] args) {
    List<PeriodEntry> periods = new ArrayList<>();

    PeriodEntry p1 = new PeriodEntry();
    p1.setPeriod("2026-01-23T12:00:00.000Z");
    p1.setWebsite_blocks(List.of(
        mockWebsiteBlock("www.amazon.com", 14, "category:shopping")
    ));

    PeriodEntry p2 = new PeriodEntry();
    p2.setPeriod("2026-01-22T10:00:00.000Z");
    p2.setWebsite_blocks(List.of(
        mockWebsiteBlock("www.temu.com", 1, "category:shopping")
    ));

    PeriodEntry p3 = new PeriodEntry();
    p3.setPeriod("2026-01-23T09:30:00.000Z");
    p3.setWebsite_blocks(List.of(
        mockWebsiteBlock("gum.criteo.com", 10, "category:shopping")
    ));

    PeriodEntry p4 = new PeriodEntry(); // null period example (will go last)
    p4.setPeriod(null);
    p4.setWebsite_blocks(List.of(
        mockWebsiteBlock("dis.criteo.com", 2, "category:shopping")
    ));

    periods.add(p1);
    periods.add(p2);
    periods.add(p3);
    periods.add(p4);

    System.out.println("Original:");
    periods.forEach(System.out::println);

    // 1) Sort objects by time ASC
    sortPeriodsAscNullLast(periods);
    System.out.println("\nSorted ASC (by period):");
    periods.forEach(System.out::println);

    // 2) Convert time inside object to epoch-millis string list (in sorted order)
    List<String> epochMillisStrings = periods.stream()
        .map(SortTimeInsideObjectDemo::toEpochMillisString)
        .collect(Collectors.toList());

    System.out.println("\nEpoch millis strings (same order):");
    System.out.println(epochMillisStrings);

    // 3) Sort objects by time DESC
    sortPeriodsDescNullLast(periods);
    System.out.println("\nSorted DESC (by period):");
    periods.forEach(System.out::println);
    
    Instant.parse(1769076000000L+"");
  }
}