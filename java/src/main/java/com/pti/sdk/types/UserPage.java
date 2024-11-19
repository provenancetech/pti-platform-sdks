/**
 * This file was auto-generated by Fern from our API Definition.
 */

package com.pti.sdk.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.pti.sdk.core.ObjectMappers;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(
    builder = UserPage.Builder.class
)
public final class UserPage implements IPage {
  private final Optional<Integer> totalPages;

  private final Optional<Integer> size;

  private final Optional<Integer> totalElements;

  private final Optional<Boolean> last;

  private final Optional<Integer> numberOfElements;

  private final Optional<Pageable> pageable;

  private final Optional<PageSort> sort;

  private final Optional<Boolean> first;

  private final Optional<Boolean> empty;

  private final Optional<List<OneOfUserSubTypes>> content;

  private final Map<String, Object> additionalProperties;

  private UserPage(Optional<Integer> totalPages, Optional<Integer> size,
      Optional<Integer> totalElements, Optional<Boolean> last, Optional<Integer> numberOfElements,
      Optional<Pageable> pageable, Optional<PageSort> sort, Optional<Boolean> first,
      Optional<Boolean> empty, Optional<List<OneOfUserSubTypes>> content,
      Map<String, Object> additionalProperties) {
    this.totalPages = totalPages;
    this.size = size;
    this.totalElements = totalElements;
    this.last = last;
    this.numberOfElements = numberOfElements;
    this.pageable = pageable;
    this.sort = sort;
    this.first = first;
    this.empty = empty;
    this.content = content;
    this.additionalProperties = additionalProperties;
  }

  @JsonProperty("totalPages")
  @Override
  public Optional<Integer> getTotalPages() {
    return totalPages;
  }

  @JsonProperty("size")
  @Override
  public Optional<Integer> getSize() {
    return size;
  }

  @JsonProperty("totalElements")
  @Override
  public Optional<Integer> getTotalElements() {
    return totalElements;
  }

  @JsonProperty("last")
  @Override
  public Optional<Boolean> getLast() {
    return last;
  }

  @JsonProperty("numberOfElements")
  @Override
  public Optional<Integer> getNumberOfElements() {
    return numberOfElements;
  }

  @JsonProperty("pageable")
  @Override
  public Optional<Pageable> getPageable() {
    return pageable;
  }

  @JsonProperty("sort")
  @Override
  public Optional<PageSort> getSort() {
    return sort;
  }

  @JsonProperty("first")
  @Override
  public Optional<Boolean> getFirst() {
    return first;
  }

  @JsonProperty("empty")
  @Override
  public Optional<Boolean> getEmpty() {
    return empty;
  }

  @JsonProperty("content")
  public Optional<List<OneOfUserSubTypes>> getContent() {
    return content;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof UserPage && equalTo((UserPage) other);
  }

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  private boolean equalTo(UserPage other) {
    return totalPages.equals(other.totalPages) && size.equals(other.size) && totalElements.equals(other.totalElements) && last.equals(other.last) && numberOfElements.equals(other.numberOfElements) && pageable.equals(other.pageable) && sort.equals(other.sort) && first.equals(other.first) && empty.equals(other.empty) && content.equals(other.content);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.totalPages, this.size, this.totalElements, this.last, this.numberOfElements, this.pageable, this.sort, this.first, this.empty, this.content);
  }

  @Override
  public String toString() {
    return ObjectMappers.stringify(this);
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private Optional<Integer> totalPages = Optional.empty();

    private Optional<Integer> size = Optional.empty();

    private Optional<Integer> totalElements = Optional.empty();

    private Optional<Boolean> last = Optional.empty();

    private Optional<Integer> numberOfElements = Optional.empty();

    private Optional<Pageable> pageable = Optional.empty();

    private Optional<PageSort> sort = Optional.empty();

    private Optional<Boolean> first = Optional.empty();

    private Optional<Boolean> empty = Optional.empty();

    private Optional<List<OneOfUserSubTypes>> content = Optional.empty();

    @JsonAnySetter
    private Map<String, Object> additionalProperties = new HashMap<>();

    private Builder() {
    }

    public Builder from(UserPage other) {
      totalPages(other.getTotalPages());
      size(other.getSize());
      totalElements(other.getTotalElements());
      last(other.getLast());
      numberOfElements(other.getNumberOfElements());
      pageable(other.getPageable());
      sort(other.getSort());
      first(other.getFirst());
      empty(other.getEmpty());
      content(other.getContent());
      return this;
    }

    @JsonSetter(
        value = "totalPages",
        nulls = Nulls.SKIP
    )
    public Builder totalPages(Optional<Integer> totalPages) {
      this.totalPages = totalPages;
      return this;
    }

    public Builder totalPages(Integer totalPages) {
      this.totalPages = Optional.ofNullable(totalPages);
      return this;
    }

    @JsonSetter(
        value = "size",
        nulls = Nulls.SKIP
    )
    public Builder size(Optional<Integer> size) {
      this.size = size;
      return this;
    }

    public Builder size(Integer size) {
      this.size = Optional.ofNullable(size);
      return this;
    }

    @JsonSetter(
        value = "totalElements",
        nulls = Nulls.SKIP
    )
    public Builder totalElements(Optional<Integer> totalElements) {
      this.totalElements = totalElements;
      return this;
    }

    public Builder totalElements(Integer totalElements) {
      this.totalElements = Optional.ofNullable(totalElements);
      return this;
    }

    @JsonSetter(
        value = "last",
        nulls = Nulls.SKIP
    )
    public Builder last(Optional<Boolean> last) {
      this.last = last;
      return this;
    }

    public Builder last(Boolean last) {
      this.last = Optional.ofNullable(last);
      return this;
    }

    @JsonSetter(
        value = "numberOfElements",
        nulls = Nulls.SKIP
    )
    public Builder numberOfElements(Optional<Integer> numberOfElements) {
      this.numberOfElements = numberOfElements;
      return this;
    }

    public Builder numberOfElements(Integer numberOfElements) {
      this.numberOfElements = Optional.ofNullable(numberOfElements);
      return this;
    }

    @JsonSetter(
        value = "pageable",
        nulls = Nulls.SKIP
    )
    public Builder pageable(Optional<Pageable> pageable) {
      this.pageable = pageable;
      return this;
    }

    public Builder pageable(Pageable pageable) {
      this.pageable = Optional.ofNullable(pageable);
      return this;
    }

    @JsonSetter(
        value = "sort",
        nulls = Nulls.SKIP
    )
    public Builder sort(Optional<PageSort> sort) {
      this.sort = sort;
      return this;
    }

    public Builder sort(PageSort sort) {
      this.sort = Optional.ofNullable(sort);
      return this;
    }

    @JsonSetter(
        value = "first",
        nulls = Nulls.SKIP
    )
    public Builder first(Optional<Boolean> first) {
      this.first = first;
      return this;
    }

    public Builder first(Boolean first) {
      this.first = Optional.ofNullable(first);
      return this;
    }

    @JsonSetter(
        value = "empty",
        nulls = Nulls.SKIP
    )
    public Builder empty(Optional<Boolean> empty) {
      this.empty = empty;
      return this;
    }

    public Builder empty(Boolean empty) {
      this.empty = Optional.ofNullable(empty);
      return this;
    }

    @JsonSetter(
        value = "content",
        nulls = Nulls.SKIP
    )
    public Builder content(Optional<List<OneOfUserSubTypes>> content) {
      this.content = content;
      return this;
    }

    public Builder content(List<OneOfUserSubTypes> content) {
      this.content = Optional.ofNullable(content);
      return this;
    }

    public UserPage build() {
      return new UserPage(totalPages, size, totalElements, last, numberOfElements, pageable, sort, first, empty, content, additionalProperties);
    }
  }
}
