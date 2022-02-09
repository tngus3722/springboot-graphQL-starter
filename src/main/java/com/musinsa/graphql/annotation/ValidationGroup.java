package com.musinsa.graphql.annotation;

import javax.validation.groups.Default;

public class ValidationGroup {
    public interface Create extends Default {};
    public interface Read extends  Default{};
    public interface Update extends  Default{};
    public interface Delete extends  Default{};
}
