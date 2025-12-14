package com.ovs.service;

import com.ovs.db.Database;
import com.ovs.security.CryptoUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public final class AuditService {
    private AuditService() {}

    public static void log(String actorEmail, String action, String details) {
        long now = System.currentTimeMillis();
        try {
            String prevHash = "GENESIS";
            try (PreparedStatement ps = Database.getConnection().prepareStatement(
                    "SELECT hash FROM audit_logs ORDER BY id DESC LIMIT 1")) {
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) prevHash = rs.getString(1);
                }
            }

            String material = prevHash + "|" + now + "|" + actorEmail + "|" + action + "|" + details;
            String hash = CryptoUtil.sha256Hex(material);

            try (PreparedStatement ins = Database.getConnection().prepareStatement(
                    "INSERT INTO audit_logs(created_at, actor_email, action, details, prev_hash, hash) VALUES(?,?,?,?,?,?)")) {
                ins.setLong(1, now);
                ins.setString(2, actorEmail);
                ins.setString(3, action);
                ins.setString(4, details);
                ins.setString(5, prevHash);
                ins.setString(6, hash);
                ins.executeUpdate();
            }
        } catch (SQLException e) {
            // ignore for demo
        }
    }
}
