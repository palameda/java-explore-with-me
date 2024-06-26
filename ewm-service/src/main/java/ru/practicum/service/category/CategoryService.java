package ru.practicum.service.category;

import ru.practicum.dto.category.CategoryDto;
import ru.practicum.dto.category.NewCategoryDto;
import ru.practicum.utility.crud.DefaultCreateService;
import ru.practicum.utility.crud.DefaultDeleteService;
import ru.practicum.utility.crud.DefaultGetService;
import ru.practicum.utility.crud.DefaultUpdateService;

public interface CategoryService extends
        DefaultCreateService<NewCategoryDto, CategoryDto>,
        DefaultUpdateService<NewCategoryDto, CategoryDto>,
        DefaultGetService<Long, CategoryDto>,
        DefaultDeleteService<Long> {
}
