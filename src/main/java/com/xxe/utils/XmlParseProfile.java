package com.xxe.utils;

public enum XmlParseProfile {
  DEFAULT(
      false, 
      true,
      true,
      "all",
      true,
      true,
      true
  ),
  BLOCK_GENERAL_ENTITY(
      false,
      false,
      true,
      "all",
      false,
      false,
      true
  ),
  SECURE(
      true,
      false,
      false,
      "",
      false,
      false,
      false
  ),
  OOB_PARAMETER_ONLY(
      false,
      false,
      true,
      "all",
      false,
      false,
      true
  ),
  OOB_GENERAL(
      false,
      true,
      true, 
      "all",
      false,
      false,
      true
  );
  private final boolean disallowDoctypeDecl;
  private final boolean externalGeneralEntities;
  private final boolean externalParameterEntities;
  private final String accessExternalDtd;
  private final boolean xIncludeAware;
  private final boolean setNamespaceAware;
  private final boolean expandEntityReferences;

  XmlParseProfile(
      boolean disallowDoctypeDecl,
      boolean externalGeneralEntities,
      boolean externalParameterEntities,
      String accessExternalDtd,
      boolean xIncludeAware,
      boolean setNamespaceAware,
      boolean expandEntityReferences
  ) {
    this.disallowDoctypeDecl = disallowDoctypeDecl;
    this.externalGeneralEntities = externalGeneralEntities;
    this.externalParameterEntities = externalParameterEntities;
    this.accessExternalDtd = accessExternalDtd;
    this.xIncludeAware = xIncludeAware;
    this.setNamespaceAware = setNamespaceAware;
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

  public boolean isSetNamespaceAware() {
    return setNamespaceAware;
  }
  public boolean isExpandEntityReferences() {
    return expandEntityReferences;
  }
}