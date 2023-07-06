package by.tms.url.repository;

import by.tms.url.model.URLModel;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

import java.net.URI;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.Optional;


@Repository
public class UrlJdbcRepository implements UrlRepository {

    private final NamedParameterJdbcOperations operations;

    public UrlJdbcRepository(NamedParameterJdbcOperations operations) {
        this.operations = operations;
    }

    @Override
    public URLModel createUrl(URI url) {
        String sql = """
                INSERT INTO url_link(full_url)
                VALUES (:url)
                RETURNING url_link.id
                """;
        Integer id = operations.queryForObject(sql, Map.of("url", url.toString()), Integer.class);
        return new URLModel(id, url);
    }

    @Override
    public Optional<URLModel> findUrlById(long id) {
        String sql = """
                SELECT id, full_url
                FROM url_link
                WHERE id = :linkId""";
        return operations.query(sql, Map.of("linkId", id), this::mapToLink)
                .stream()
                .findFirst();

    }

    private URLModel mapToLink(ResultSet resultSet, int rowNum) throws SQLException {
        return new URLModel(
                resultSet.getLong("id"),
                URI.create(resultSet.getString("full_url")));
    }
}

