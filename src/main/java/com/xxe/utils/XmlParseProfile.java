package com.xxe.utils;

public enum XmlParseProfile {
  DEFAULT(
      false, 
      true,
      true,
      "all",
      false,
      true
  ),
  BLOCK_GENERAL_ENTITY(
      false,
      false,
      true,
      "all",
      false,
      true
  ),
  SECURE(
      true,
      false,
      false,
      "",
      false,
      false
  ),
  OUT_OF_BAND(
      false,
      false,
      true,   // allow parameter entities for OOB lab simulation
      "all",
      false,
      true
  );

  private final boolean disallowDoctypeDecl;
  private final boolean externalGeneralEntities;
  private final boolean externalParameterEntities;
  private final String accessExternalDtd;
  private final boolean xIncludeAware;
  private final boolean expandEntityReferences;

  XmlParseProfile(
      boolean disallowDoctypeDecl,
      boolean externalGeneralEntities,
      boolean externalParameterEntities,
      String accessExternalDtd,
      boolean xIncludeAware,
      boolean expandEntityReferences
  ) {
    this.disallowDoctypeDecl = disallowDoctypeDecl;
    this.externalGeneralEntities = externalGeneralEntities;
    this.externalParameterEntities = externalParameterEntities;
    this.accessExternalDtd = accessExternalDtd;
    this.xIncludeAware = xIncludeAware;
    this.expandEntityReferences = expandEntityReferences;
  }

  public boolean isDisallowDoctypeDecl() {
    return disallowDoctypeDecl;
  }

  public boolean isExternalGeneralEntities() {
    return externalGeneralEntities;
  }

  public boolean isExternalParameterEntities() {
    return externalParameterEntities;
  }

  public String getAccessExternalDtd() {
    return accessExternalDtd;
  }

  public boolean isXIncludeAware() {
    return xIncludeAware;
  }

  public boolean isExpandEntityReferences() {
    return expandEntityReferences;
  }
}