/*
 * Copyright 2014 Google Inc. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.google.identitytoolkit;

import com.google.common.collect.Lists;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Wrapper class containing user attributes.
 */
public class GitkitUser {
  private String email;
  private String localId;
  private String name;
  private String photoUrl;
  private String currentProvider;
  private Integer issued;
  private Integer expires;
  private String displayName;
  private Boolean emailVerified;

  private List<ProviderInfo> providers = Lists.newArrayList();
  private byte[] hash;
  private byte[] salt;

  public String getEmail() {
    return this.email;
  }

  public GitkitUser setEmail(String email) {
    this.email = email;
    return this;
  }

  public String getLocalId() {
    return this.localId;
  }

  public GitkitUser setLocalId(String localId) {
    this.localId = localId;
    return this;
  }

  public String getName() {
    return this.name;
  }

  public GitkitUser setName(String name) {
    this.name = name;
    return this;
  }

  public String getPhotoUrl() {
    return this.photoUrl;
  }

  public GitkitUser setPhotoUrl(String photoUrl) {
    this.photoUrl = photoUrl;
    return this;
  }

  public String getCurrentProvider() {
    return this.currentProvider;
  }

  public GitkitUser setCurrentProvider(String currentProvider) {
    this.currentProvider = currentProvider;
    return this;
  }

  public List<ProviderInfo> getProviders() {
    return this.providers;
  }

  public Boolean isEmailVerified() {
    return this.emailVerified;
  }

  public GitkitUser setEmailVerified(Boolean emailVerified) {
    this.emailVerified = emailVerified;
    return this;
  }

  public Integer getExpires() {
    return this.expires;
  }

  public GitkitUser setExpires(Integer expires) {
    this.expires = expires;
    return this;
  }

  public String getDisplayName() {
    return this.displayName;
  }

  public GitkitUser setDisplayName(String displayName) {
    this.displayName = displayName;
    return this;
  }

  public Integer getIssued() {
    return this.issued;
  }

  public GitkitUser setIssued(Integer issued) {
    this.issued = issued;
    return this;
  }

  public GitkitUser setProviders(JSONArray providers) throws JSONException {
    List<ProviderInfo> providerInfo = new ArrayList<ProviderInfo>();
    if (providers != null) {
      for (int i = 0; i < providers.length(); i++) {
        JSONObject provider = providers.getJSONObject(i);
        providerInfo.add(new ProviderInfo(provider.getString("providerId"), provider
            .getString("federatedId"), provider.optString("displayName"), provider
            .optString("photoUrl")));
      }
    }
    this.providers = providerInfo;
    return this;
  }

  public GitkitUser setProviders(List<ProviderInfo> providers) throws JSONException {
    this.providers.clear();
    this.providers.addAll(providers);
    return this;
  }

  public byte[] getHash() {
    return this.hash;
  }

  public GitkitUser setHash(byte[] hash) {
    this.hash = Arrays.copyOf(hash, hash.length);
    return this;
  }

  public byte[] getSalt() {
    return this.salt;
  }

  public GitkitUser setSalt(byte[] salt) {
    this.salt = Arrays.copyOf(salt, salt.length);
    return this;
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder =
        new StringBuilder("[").append("\n\tlocalId: ").append(this.localId).append("\n\temail: ")
            .append(this.email).append("\n\tname: ").append(this.name).append("\n\tphotoUrl: ")
            .append(this.photoUrl).append("\n\tcurrent idp: ").append("\n\temailVerified: ")
            .append(this.emailVerified).append(this.currentProvider).append("\n\tproviders: [");
    for (ProviderInfo providerInfo : this.providers) {
      stringBuilder.append("\n\t\tidp: ").append(providerInfo.getProviderId()).append(
          "\n\t\tfedId: ").append(providerInfo.getFederatedId()).append("\n\t\tname: ").append(
          providerInfo.getName()).append("\n\t\tphotoUrl: ").append(providerInfo.getPhotoUrl());
    }
    return stringBuilder.append("]\n]").toString();
  }

  /**
   * Wrapper class containing the associated identity providers of a user.
   */
  public static class ProviderInfo {
    private final String providerId;
    private final String federatedId;
    private final String name;
    private final String photoUrl;

    public ProviderInfo(String providerId, String federatedId, String name, String photoUrl) {
      this.providerId = providerId;
      this.federatedId = federatedId;
      this.name = name;
      this.photoUrl = photoUrl;
    }

    public String getProviderId() {
      return this.providerId;
    }

    public String getFederatedId() {
      return this.federatedId;
    }

    public String getName() {
      return this.name;
    }

    public String getPhotoUrl() {
      return this.photoUrl;
    }
  }

}
