/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.entertainment.catalog;

import static org.junit.Assert.*;
import java.util.Collection;
import java.util.Map;

import org.junit.Test;
import com.entertainment.Television;

public class CatalogTest {

  @Test (expected = UnsupportedOperationException.class)
  public void getInventory_shouldReturnReadOnlyCollection() {
    Collection<Television> tvs = Catalog.getInventory();  //should be read-only
    tvs.clear();                                          // should throw exception
  }

  @Test
  public void findByBrands_shouldReturnPopulatedMap_brandsArePassed() {
    Map<String, Collection<Television>> tvMap = Catalog.findByBrands("Sony", "Zenith");
    assertEquals(2, tvMap.size()); //asserts that there are two rows in map

    Collection<Television> sonyTVs = tvMap.get("Sony");
    for (Television tv : sonyTVs) {
      assertEquals("Sony", tv.getBrand());
    }
    Collection<Television> zenithTvs = tvMap.get("Zenith");
    for (Television tv : zenithTvs) {
      assertEquals("Zenith", tv.getBrand());
    }

  }

  @Test
  public void findByBrands_shouldReturnEmptyMap() {
    Map<String, Collection<Television>> tvMap = Catalog.findByBrands();

    assertTrue(tvMap.isEmpty());
  }

  @Test
  public void findByBrand_shouldReturnCollection_BrandFound() {
    Collection<Television> tvs = Catalog.findByBrand("Sony");
    for (Television tv : tvs){

      assertEquals("Sony", tv.getBrand());
    }
    assertEquals(7, tvs.size());
  }

  /**
   * Contract: a no-matches result should be an empty collection (not null).
   */

  @Test
  public void findByBrand_shouldReturnEmptyCollection_brandNotFound() {
    Collection<Television> tvs = Catalog.findByBrand("NO-MATCHES");
    assertNotNull(tvs);
    assertTrue(tvs.isEmpty());
  }
}